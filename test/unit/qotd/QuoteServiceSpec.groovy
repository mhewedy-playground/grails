package qotd

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(QuoteService)
class QuoteServiceSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "static quote service always return quiche quote" (){
		when:
		def staticQuote = service.getStaticQuote()
		
		then:
		staticQuote.content == 'Real Programmers do not each Quiche'
		staticQuote.author == 'Anonymous'
	}
}
