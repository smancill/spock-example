import spock.lang.Specification
import spock.lang.TempDir

import java.nio.file.Files
import java.nio.file.Path


class TempDirSpec extends Specification {

    @TempDir Path tmpDir

    def "Try creating multiple dirs"() {
        when:
        var dir = Files.createDirectory(tmpDir.resolve(name))

        then:
        Files.exists(dir)

        where:
        name << ["aaa", "bbb", "ccc"]
    }

    def "Try creating single dir"() {
        when:
        var dir = Files.createDirectory(tmpDir.resolve("foo"))

        then:
        Files.exists(dir)
    }

    def "Do nothing just test the temp dir existance"() {
        expect:
        Files.exists(tmpDir)
    }

    def "Do nothing just test the temp dir existance this time with unroll"() {
        expect:
        Files.exists(tmpDir)

        where:
        n << [1, 2, 3]
    }
}
