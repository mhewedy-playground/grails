package qotd

class QuoteController {
	
	def QuoteService quoteService
	
	static defaultAction = 'home'
	static scaffold = true
	
	def home = {
		render "<h1>Real Programmers do not each Quiche</h1>"
	}
	
	def random = {
		[quote: quoteService.getRandmonQuote()]
	}
	
	def ajaxRandom = {
		def quote = quoteService.getRandmonQuote()
		render {
			q(quote.content)
			p(quote.author)
		}
	}
}
