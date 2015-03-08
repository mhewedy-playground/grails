import qotd.Quote
import qotd.QuoteAnalyzer

//new Quote(content: '', author: '').save()
//new Quote(content: '', author: '').save(flush: true)

def quoteAnalyzer = new QuoteAnalyzer(Quote.findAll())

try {
	def file = new File('report.txt')

	file.withPrintWriter { w ->
		w.println """\
Quote report
------------

Total: ${quoteAnalyzer.quoteCount}

Number of quotes by author:
		"""
		def map = quoteAnalyzer.quoteCountPerAuthor.sort{ -it.value}
		map.each {
			w.println " " + it.key.padRight(150) + it.value
		}
	}

	println file.text

}catch(IOException ex) {
	println "Error opening file 'report.txt' !"
}

