Diffie–Hellman key exchange (D–H) [nb 1] is a method of securely exchanging cryptographic keys over a public channel.The Diffie–Hellman key exchange method allows two parties that have no prior knowledge of each other to jointly establish a shared secret key over an insecure channel. This key can then be used to encrypt subsequent communications using a symmetric key cipher.
Cryptographic explanation

The simplest and the original implementation of the protocol uses the multiplicative group of integers modulo p, where p is prime, and g is a primitive root modulo p. These two values are chosen in this way to ensure that the resulting shared secret can take on any value from 1 to p–1. Here is an example of the protocol, with non-secret values in blue, and secret values in red.

    Alice and Bob agree to use a modulus p = 23 and base g = 5 (which is a primitive root modulo 23).
    Alice chooses a secret integer a = 6, then sends Bob A = ga mod p
        A = 56 mod 23 = 8
    Bob chooses a secret integer b = 15, then sends Alice B = gb mod p
        B = 515 mod 23 = 19
    Alice computes s = Ba mod p
        s = 196 mod 23 = 2
    Bob computes s = Ab mod p
        s = 815 mod 23 = 2
    Alice and Bob now share a secret (the number 2).

Both Alice and Bob have arrived at the same value s, because, under mod p,

A b mod p = g a b mod p = g b a mod p = B a mod p {\displaystyle A^{b}{\bmod {\,}}p=g^{ab}{\bmod {\,}}p=g^{ba}{\bmod {\,}}p=B^{a}{\bmod {\,}}p} {\displaystyle A^{b}{\bmod {\,}}p=g^{ab}{\bmod {\,}}p=g^{ba}{\bmod {\,}}p=B^{a}{\bmod {\,}}p}[8]

More specifically,

( g a mod p ) b mod p = ( g b mod p ) a mod p {\displaystyle (g^{a}{\bmod {\,}}p)^{b}{\bmod {\,}}p=(g^{b}{\bmod {\,}}p)^{a}{\bmod {\,}}p} {\displaystyle (g^{a}{\bmod {\,}}p)^{b}{\bmod {\,}}p=(g^{b}{\bmod {\,}}p)^{a}{\bmod {\,}}p}

Note that only a, b, and (gab mod p = gba mod p) are kept secret. All the other values – p, g, ga mod p, and gb mod p – are sent in the clear. Once Alice and Bob compute the shared secret they can use it as an encryption key, known only to them, for sending messages across the same open communications channel.


