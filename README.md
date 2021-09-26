# ReverseXOR
ReverseXor encryption in Java.

It consists of two parts:

To encrypt:

ReverseMod: modified string reverse that separates the string into groups of the given size and reverts its content individually.
Example using reverse length = 4: Hello World -> lleHow odlr

Later, xor is applied to each character using as an index each character of the given password.

To decrypt: First apply xor and then ReverseMod.
