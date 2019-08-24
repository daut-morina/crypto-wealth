# Crypto Wealth

## Run

* `git clone` the project and `cd` into the directory.
* Run `./gradlew test` to run the test suite, everything should be green.
* Run `./gradlew run` to run the app, you should get a nicely formatted list with your assets.

## Design

I'm a proponent of _Domain-Driven Design_ and _Hexagonal Architecture_, I tried to incorporate those ideas without going overboard. I also tried to make the type system do the heavy lifting by being as explicit as possible with the types.

### TODO

* I went light on Error-Handling. I like `Optional<T>` or even `Result<S, T>` types.
* Also specify and verify `target`, currently it's just implicitly _EUR_.
