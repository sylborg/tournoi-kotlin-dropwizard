package fr.labs.sza.component

import fr.labs.sza.module.ApplicationModule
import dagger.Component
import fr.labs.sza.tournoiApplication

@Component(modules = arrayOf(ApplicationModule::class))
interface ApplicationComponent {

    fun inject(application: tournoiApplication)

}