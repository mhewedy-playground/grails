package qotd

class QuoteAnalyzer {

	private final List<Quote> quotes

	QuoteAnalyzer(List<Quote> quotes) {
		this.quotes = quotes?:new ArrayList()
	}

	def getQuoteCount() {
		this.quotes.size()
	}

	Map<String, Integer> getQuoteCountPerAuthor() {
		def ret = [:]

		quotes.each{
			if (ret.containsKey(it.author)) {
				ret[it.author]++
			}else {
				ret[it.author] = 1
			}
		}
		ret
	}

	def getAverageQuoteLenth() {
		if (quotes) {
			quotes.sum {it.content.length()} /quotes.size()
		}else {
			0.0
		}
	}
}
