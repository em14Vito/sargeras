package cn.com.denny.sargeras.mongodb;

import com.mongodb.MongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import xyz.morphia.Datastore;
import xyz.morphia.Morphia;


@Configuration
public class MorphiaConfig {

    @Bean
    public Datastore getDatastore() {
        final Morphia morphia = new Morphia();

        morphia.mapPackage("cn.com.denny.sargeras.mongodb.dataobject");

        // create the Datastore connecting to the default port on the local host
        final Datastore datastore = morphia.createDatastore(new MongoClient(), "morphia_example");
        datastore.ensureIndexes();
        return datastore;
    }
}
