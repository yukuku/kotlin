fun box(): String {
    var encl1 = "fail";
    test {
        {
            {
                encl1 = "OK"
            }()
        }()
    }

    return encl1
}

inline fun test(crossinline s: () -> Unit) {
    {
        {
            s()
        }()
    }()
}

// 3 INNERCLASS Kt10259_3Kt\$test\$1 null
// 2 INNERCLASS Kt10259_3Kt\$test\$1\$1
// 2 INNERCLASS Kt10259_3Kt\$box\$\$inlined\$test\$1\s
// 2 INNERCLASS Kt10259_3Kt\$box\$\$inlined\$test\$1\$1\s
// inlined:
// 2 INNERCLASS Kt10259_3Kt\$box\$\$inlined\$test\$1\$1\$lambda\$1\s
// 2 INNERCLASS Kt10259_3Kt\$box\$\$inlined\$test\$1\$1\$lambda\$1\$1\s
// 13 INNERCLASS