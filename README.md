Individual Competency Control project,

Classes contain comments explaining my thought process and how the structure relate to the SOLID principles.

My understanding of the SOLID principles are as follows.

'Single Responsibility Principle' - Code should have a single responsibility or concern,  Not only is a class following this easier to test, read, reuse and understand.  It also has the effect that one only ever has a reason to change it if that concern changes.

'Open Closed Principle' - Code should be open to extension but closed to modification,  This goes hand in hand with the SRP principle.  We shouldn't need to change the code simply because we want to add new functionality to the main concern. (Such as more members,methods or changing implementation)
Instead we write the program so that one can write extensions that uses the base of what we already have.  Mainly through abstractions such as interfaces to create new implementations, or through inheritance to create "is_A" relationships.

'Liskov Subtitution Principle' - Objects of a superclass should be replaceable with objects of its subclasses without affecting the program's correctnes,  There are 4 core rules to this.  
Preconditions cannot be strengthened in the subtype.
Postconditions cannot be weakened in the subtype.
Invariants cannot be weakened in the subtype.
Exceptions (if any) must be of the same type than the ones thrown by its parent

This creates a sort of contract on how we handle inheritance which mostly favor the "Is_A" relationship,  Note that we can still override methods as long as we adhere to the 4 core rules of Liskov.

'Interface Segregation Principle' - "Clients should not be forced to depend upon interfaces that they do not use" is the quote of how this works,  and its simple enough.  We aim to split interfaces in as small (but usable) chunks as possible to define very specific tasks or frameworks we wish to use.
One example in this project is how the Menu object has separated inputting user data, and user selecting options into two separate interfaces.   or how the Person interface is what the Candidate interface builds on.

'Dependency Inversion Principle' - In short,  Code should use abstractions instead of concrete implementations (classes), this separates high-level modules and low-level modules with a layer of abstraction which depends not in implementation, but rather what we say that these abstractions can do.
In other words,  We do this to decouple unrelated classes from eachother which is why this principle mostly is fulfilled by adhering to Open-Closed and Liskov
