package mathologer

import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification

/**
 * See the API for {@link ControllerUnitTest} for usage instructions.
 */
class MultiplicationCircleControllerSpec extends Specification implements ControllerUnitTest<MultiplicationCircleController> {

    void "asking for #segments segments should provide #segments lines"(segments) {
        given:
        def model = new MultiplicationCircleModel(segmentCount: segments, tableBase: 2)
        when:
        controller.index(model)
        then:
        model.lines.size() == segments
        // Notice the usage of 'where' here!
        where:
        segments << [0, 1, 10, 100]
    }
}
