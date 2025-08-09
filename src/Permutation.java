public class Permutation {
  public void doPermutationAddiction(int a, int b) {
    a += b;
    b = a;
    a = a - b;
  }

  public void doPermutationXor(int a, int b) {
    a ^= b;
    b ^= a;
    a ^= b;
  }
}