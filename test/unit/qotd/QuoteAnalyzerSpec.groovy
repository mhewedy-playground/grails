package qotd

import spock.lang.*

class QuoteAnalyzerSpec extends Specification {

	@Shared
	def quotes = [
		new Quote(author: "Peter Ledbrook", content: "Time waits for no man"),
		new Quote(author: "Glen Smith", content: "Groovy solves all problems")
	]


	@Unroll
	def "Total number of quotes"() {
		given: "An analyzer initialized with known quotes"
		def quoteAnalyzier = new QuoteAnalyzer(inputQuotes)

		when: "I ask for the quote count"
		def quoteCount = quoteAnalyzier.quoteCount

		then: "The number of quotes in the test list is returned"
		quoteCount == expected

		where:
		inputQuotes | expected
		quotes		| 2
		[]			| 0
		null		| 0
	}

	@Unroll
	def "Number of quotes per author" (){
		given: "An analyzer initialized with known quotes"
		def quoteAnalyzier = new QuoteAnalyzer(inputQuotes)

		expect: "The per-author quote count is correct"
		expected == quoteAnalyzier.quoteCountPerAuthor

		where:
		inputQuotes | expected
		quotes		| ['Peter Ledbrook': 1, 'Glen Smith': 1]
		[]			| [:]
	}
	
	@Unroll
	def "Average characters in quotes" (){
		given: "An analyzer initialized with known quotes"
		def quoteAnalyzier = new QuoteAnalyzer(inputQuotes)
		
		expect: "The avg is correct"
		expected == quoteAnalyzier.averageQuoteLenth
		
		where:
		inputQuotes | expected
		[]			| 0.0
		quotes		| 23.5
	}

}
