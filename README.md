
# JavaBenchmarks

JavaBenchmarks is a set of performance tests written in Java 21 designed to measure how fast common Java collections, third-party libraries (like fastutil), hashing methods, and memory access patterns work. It uses JMH (Java Microbenchmark Harness) to run precise microbenchmarks, saves results as JSON files, and includes a JavaFX GUI for visualizing the data.

---

## Technical Details

### How the Benchmarks Work

- **Based on JMH:**  
  Benchmarks use JMH annotations to measure things like:
    - Access times (both sequential and random)
    - Different hashing approaches (e.g., `BlockKey` vs. `String` keys)
    - Comparing built-in Java Collections with fastutil alternatives
- **Output Organization:**  
  Results are saved in JSON files inside `results/<benchmark-name>/` folders, with timestamps for easy tracking and comparison.

### Example Benchmark Results

Tests ran on a modern desktop (Ryzen 7 9700X with DDR5 RAM). Keep in mind that actual numbers can change depending on your hardware and JVM.

#### Access Time Results
| Size       | Random Access | Sequential Access |
|------------|---------------|-------------------|
| 512        | 0.170 ns/op   | 0.051 ns/op       |
| 4096       | 0.209 ns/op   | 0.050 ns/op       |
| 16384      | 0.288 ns/op   | 0.058 ns/op       |
| ...        | ...           | ...               |
| 4,194,304  | 0.893 ns/op   | 0.059 ns/op       |

**Key point:** Accessing memory sequentially is much faster, showing how CPU cache prefetching helps performance.

#### Hashing Performance
| Key Type   | Size      | Score (ns/op) |
|------------|-----------|---------------|
| BlockKey   | 1–10k     | ~3.0          |
| String     | 1–10k     | ~50–53        |

**Note:** Hashing small primitive keys like `BlockKey` is much faster than using `String` keys.

#### Collections Performance (ArrayList example)
| Test       | Size     | Existing (ns/op) | Non-existing (ns/op) |
|------------|----------|------------------|----------------------|
| arrayList  | 1        | 0.687            | 1.745                |
|            | 10       | 3.107            | 3.999                |
|            | 100      | 12.220           | 21.967               |
|            | 1,000    | 105.364          | —                    |
|            | 10,000   | 2427.705         | —                    |

**Note:** Time grows roughly linearly with the size of the collection.

#### fastutil vs Java Collections
- fastutil’s LongSet is faster for membership tests, especially with existing elements.
- The speed difference is bigger with large datasets or checking for missing items.

### Automation and Flexibility

- The test runner automatically creates result folders for each run.
- JMH options used include:
    - Configurable warm-up and measurement iterations
    - Average time mode (`Mode.AverageTime`)
    - Results shown in nanoseconds

---

## Important Notes

- **Hardware and JVM differences:**  
  Results depend heavily on CPU, JVM version/settings, memory, and OS. Always test on your actual target machine.
- **Benchmark accuracy:**  
  Benchmarks try to isolate core operations, but JVM optimizations, garbage collection, and method inlining can affect results.
- **Sequential vs Random:**  
  Sequential memory access benefits from CPU cache prefetching, making it much faster.
- **Third-party libraries:**  
  fastutil and similar libraries offer good speed-ups for primitive collections and certain patterns.
- **Hashing:**  
  Hashing small primitive keys beats hashing strings by a wide margin.
- **Expandable:**  
  The suite is modular and easy to extend with new benchmarks.

---

## How to Read the Results

- Lower `Score` (ns/op) means better performance.
- Watch the `Error` column for jitter—large errors mean less reliable results.
- Prefer tests with more iterations and stable error margins.

**Tip:** For best accuracy, run on isolated machines and repeat tests multiple times.

---

## Summary

JavaBenchmarks offers a simple, extendable toolkit for checking performance of Java data structures, hashing, and memory use. Use it to guide choices on data structures and algorithms and to validate performance for your applications.
