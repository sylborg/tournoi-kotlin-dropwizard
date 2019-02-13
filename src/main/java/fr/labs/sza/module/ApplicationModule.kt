package fr.labs.sza.module

import dagger.Module
import fr.labs.sza.tournoiConfiguration

@Module
class ApplicationModule(private val tournoiConfiguration: tournoiConfiguration)
