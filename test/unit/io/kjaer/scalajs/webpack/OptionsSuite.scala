package io.kjaer.scalajs.webpack

import typings.schemaUtils.{mod => validateOptions}

class OptionsSuite extends munit.FunSuite {
  test("default options match schema") {
    validateOptions(Options.schema, Options.defaults)
  }
}
