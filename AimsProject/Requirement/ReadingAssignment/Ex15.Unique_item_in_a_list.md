When overriding the equals() method of the Object class, you will have to cast the Object
parameter obj to the type of Object that you are dealing with. For example, in the Media class,
you must cast the Object obj to a Media, and then check the equality of the two objects’ attributes
as the above requirements (i.e. title for Media; title and length for Track). If the
passing object is not an instance of Media, what happens?

# Answers: 
- If two objects are from different classes, the equals() method returns false immediately.

- If they are from the same class but the class is not Media or Track, the default Object.equals() is used.








