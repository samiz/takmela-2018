Takmela is a general parser and a (possibly) new (-ish) parsing technique.

## Features

* Can cope with ambiguous grammars and left recursion, both direct and indirect.
* Can parse text from a grammar directly, no need for code generation.
* Automatically generates a parse forest for you.
* The parser code is rather small and simple, with [ParseEngine.java](./Takmela/src/takmela/engine/ParseEngine.java) being less than 500 LOC. It should be easy to port to many languages and platforms!
* Grammar syntax relatively similar to ANTLR (but Takmela is NOT a drop-in replacement).

## Documentation

* For a walkthrough to create a simple grammar and parse input with it, see [Getting started](doc/Getting_started.md)
* To learn how to write grammars for Takmela, see the [Grammar spec](doc/Grammar_spec.md)
* If you like to hack on the code, see the internals guide (to be written).
* If you like to learn how Takmela works, read the [Theory documentation](doc/Theory_Documentation.md)

## Wild ride ahead

This project is at its very early stages, and a lot of things are missing, wrong, or subject to change. Brave souls are welcome to explore and tinker with Takmela but it's far from ready for production use. In particular:
* No intelligent error handling yet. The parser deals with errors by throwing an exception and stopping.
* Code contains hacks, a lot of debug print statements, and general cruft. Do not expect best practices here!
* Unicode? What's that?
* Performance still needs to be carefully analyzed (both time complexity and benchmark-wise).
* Expect bugs. Lots of them.

## Future work

* Generating ANTLR-like tree visitors/listeners.
* Exploring possibilities for time and space optimizations.
* Better error handling and recovery.
* Incremental lexing and parsing for integration in IDEs
* Stream parsing and gradual creation of parse trees.

Some of the above is research dependent and will only be added if I'm successful at implementing it :)

## Credit

After writing the implementation of Takmela I found out that the exact same parsing technique was described in Mark Johnson's paper "Squibs and Discussions: Memoization in Top-Down Parsing" in 1995. I believe Takmela to be a variant implementation of or a derivative from his algorithm.

Takmela steals many ideas from ANTLR. I believe ANTLR4 presents a very usable and functional API for running a parser and I tried to imitate that design.

The author of Takemla admires the above works and looks up to their creators, but is not affiliated with any of them.

## License

This program is released under the MIT license

Copyright (c) 2018 Takmela parser author

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.

## Open source libraries used

Open source libraries used in Takmela and their respective licences are included in CREDITS.md
