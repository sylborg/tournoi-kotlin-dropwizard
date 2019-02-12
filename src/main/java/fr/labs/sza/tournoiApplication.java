package fr.labs.sza;

import fr.labs.sza.resources.JoueurResource;
import fr.labs.sza.resources.TournoiResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class tournoiApplication extends Application<tournoiConfiguration> {

    public static void main(final String[] args) throws Exception {
        new tournoiApplication().run(args);
    }

    @Override
    public String getName() {
        return "tournoiKotlin";
    }

    @Override
    public void initialize(final Bootstrap<tournoiConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final tournoiConfiguration configuration,
                    final Environment environment) {
        environment.jersey().register(new JoueurResource());
        environment.jersey().register(new TournoiResource());
    }

}
