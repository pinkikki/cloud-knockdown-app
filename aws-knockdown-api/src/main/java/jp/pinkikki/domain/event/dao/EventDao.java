package jp.pinkikki.domain.event.dao;

import jp.pinkikki.domain.event.entity.Event;
import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

import java.util.stream.Stream;

@ConfigAutowireable
@Dao
public interface EventDao {

    @Select
    Stream<Event> findAll();

    @Select
    Event findOne(int id);
}
