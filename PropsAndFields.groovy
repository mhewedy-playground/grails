class Person{
	String name				// <- Property
	private String fullName // <- Field

	def getAge(){			// <- Property
		return 10
	}
}

person = new Person(name: 'Ali', fullName: 'ezzat')

println person.getName()
println person.getAge()
//println person.getFullName()	// Fields cannot called using getXXX

println person.name
println person.age
println person.fullName
