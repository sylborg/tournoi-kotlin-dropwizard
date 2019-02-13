package fr.labs.sza

import fr.labs.sza.component.ApplicationComponent
import fr.labs.sza.component.DaggerApplicationComponent
import fr.labs.sza.resources.JoueurResource
import fr.labs.sza.resources.TournoiResource
import io.dropwizard.Application
import io.dropwizard.setup.Bootstrap
import io.dropwizard.setup.Environment

class tournoiApplication : Application<tournoiConfiguration>() {


    private var applicationComponent: ApplicationComponent? = null

    override fun getName(): String {
        return "tournoiKotlin"
    }

    override fun initialize(bootstrap: Bootstrap<tournoiConfiguration>?) {
        // TODO: application initialization
        applicationComponent = DaggerApplicationComponent.builder().build()
        applicationComponent!!.inject(this)
    }

    override fun run(configuration: tournoiConfiguration,
                     environment: Environment) {
        environment.jersey().register(JoueurResource())
        environment.jersey().register(TournoiResource())
    }

    companion object {

        @Throws(Exception::class)
        @JvmStatic
        fun main(args: Array<String>) {
            tournoiApplication().run(*args)
        }
    }

}
