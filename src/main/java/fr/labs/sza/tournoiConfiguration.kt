package fr.labs.sza

import io.dropwizard.Configuration
import com.fasterxml.jackson.annotation.JsonProperty
import org.hibernate.validator.constraints.*


class tournoiConfiguration : Configuration() {

    @NotEmpty
    @get:JsonProperty
    @set:JsonProperty
    var template: String? = null

    @NotEmpty
    @get:JsonProperty
    @set:JsonProperty
    var defaultName = "Stranger"

}
