package testing.rename

public open class C {
    public fun `foo$bar`() = 1

    public fun foo() = `foo$bar`()
}
