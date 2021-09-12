package com.airbusinventory.products.idgenerator;

import java.io.Serializable;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.id.enhanced.SequenceStyleGenerator;

public class PidGenerator implements IdentifierGenerator {
	
	private static final int LENGTH = 2;

	@Override
    public Serializable generate(
      SharedSessionContractImplementor session, Object obj) 
      throws HibernateException {

        String query = String.format("select %s from %s", 
            session.getEntityPersister(obj.getClass().getName(), obj)
              .getIdentifierPropertyName(),
            obj.getClass().getSimpleName());

        Stream<String> ids = session.createQuery(query).stream();

        Long max = ids.map(o -> o.replace("P", ""))
          .mapToLong(Long::parseLong)
          .max()
          .orElse(0L);
        
        String num = ""+(max + 1);

        return "P"+ IntStream.range(0, LENGTH-num.length()).mapToObj(i -> "0").collect(Collectors.joining()) + num;
    }

	
	
}
