package mathologer

import geb.spock.GebSpec
import grails.testing.mixin.integration.Integration

/**
 * See http://www.gebish.org/manual/current/ for more instructions
 */
@Integration
class MultiplicationCircleSpec extends GebSpec {

    def setup() {
        browser.driver.javascriptEnabled = true
    }

    void "Changing segment count with JavaScript"() {
        when:
        go '/multiplicationCircle.html'
        then:
        title == "Multiplication Circle"
        $("form").segmentCount == "10"

        when: "click to bump value up"
        $("#segmentCountUp").click()
        then: "the field is bumped up"
        $("form").segmentCount == "11"

        when: "click to bump value down"
        $("#segmentCountDown").click()
        then: "the field is bumped down"
        $("form").segmentCount == "10"
    }

    void "Changing table base with JavaScript"() {
        when:
        go '/multiplicationCircle.html'
        then:
        title == "Multiplication Circle"
        $("form").tableBase == "2"

        when: "click to bump value up"
        $("#tableBaseUp").click()
        $("#tableBaseUp").click()
        then: "the field is bumped up"
        $("form").tableBase == "4"

        when: "click to bump value down"
        $("#tableBaseDown").click()
        then: "the field is bumped down"
        $("form").tableBase == "3"
    }

}
