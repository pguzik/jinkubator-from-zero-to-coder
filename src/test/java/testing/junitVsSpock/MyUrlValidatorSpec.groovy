package testing.junitVsSpock

import spock.lang.Specification

/**
 * @author Piotrek
 */
class MyUrlValidatorSpec extends Specification {

    def "test-multiple-urls"() {
        given: "create the validator object accepting file urls"
            MyUrlValidator myValidator = new MyUrlValidator()
            myValidator.allowFileUrls(true)

        expect: "Validate a URL and see if it is valid"
            valid == myValidator.isValidUrl(testUrl)

        where:
        testUrl                  | valid
        "http://www.google.com"  | true
        "file://home/users"      | true
        "http://localhost:8080/" | false
    }
}
