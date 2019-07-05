import org.junit.Assert
import org.junit.Test

class TestLazyProperty {
    @Test fun testLazy() {
        var initialized = false
        val lazyProperty = LazyProperty { initialized = true; 42 }
        Assert.assertFalse("Property shouldn't be initialized before access", initialized)
        val result: Int = lazyProperty.lazy
        Assert.assertTrue("Property should be initialized after access", initialized)
        Assert.assertTrue("Property should be initialized after access", 42 == result)
    }

    @Test fun initializedOnce() {
        var initialized = 0
        val lazyProperty = LazyProperty { initialized++; 42 }
        lazyProperty.lazy
        lazyProperty.lazy
        Assert.assertEquals("Lazy property should be initialized only once", 1, initialized)

    }
}
