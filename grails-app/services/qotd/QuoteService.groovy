package qotd

import grails.transaction.Transactional

@Transactional
class QuoteService {

	def getStaticQuote = {
		new Quote(content: 'Real Programmers do not each Quiche', author: 'Anonymous');
	}

	def getRandmonQuote = {
		def quoteList = Quote.findAll();
		def size = quoteList.size()

		if (size > 0){
			quoteList[new Random().nextInt(quoteList.size)]
		}else {
			getStaticQuote()
		}
	}
}
