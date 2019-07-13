package cn.com.denny.sargeras.mongodb;

import cn.com.denny.sargeras.mongodb.dataobject.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import xyz.morphia.Datastore;

import javax.annotation.Resource;

@RestController
public class TestController {

    @Resource
    private Datastore datastore;
    @RequestMapping(value = "/home",method = RequestMethod.GET)
    public void home(){

        final Employee elmer = new Employee("Elmer Fudd", 50000.0);
        datastore.save(elmer);

        final Employee daffy = new Employee("Daffy Duck", 40000.0);
        datastore.save(daffy);

        final Employee pepe = new Employee("Pepé Le Pew", 25000.0);
        datastore.save(pepe);

        elmer.getDirectReports().add(daffy);
        elmer.getDirectReports().add(pepe);

        datastore.save(elmer);
    }

}
