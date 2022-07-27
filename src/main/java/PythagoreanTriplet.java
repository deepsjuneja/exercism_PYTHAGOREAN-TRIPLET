import java.util.ArrayList;
import java.util.List;

class PythagoreanTriplet {
    private final int a, b, c;

    PythagoreanTriplet(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (!(o instanceof PythagoreanTriplet))
            return false;
        
        PythagoreanTriplet other = (PythagoreanTriplet) o;

        return a == other.a &&
               b == other.b &&
               c == other.c;
    }

    static PythagoreanTripletMaker makeTripletsList() {
        return new PythagoreanTripletMaker();
    }

    static class PythagoreanTripletMaker {

        private int factorsLessThanOrEqualTo;
        private int sumTo;

        PythagoreanTripletMaker withFactorsLessThanOrEqualTo(int limit) {
            factorsLessThanOrEqualTo = limit;
            return this;
        }
    
        PythagoreanTripletMaker thatSumTo(int sum) {
            sumTo = sum;
            return this;
        }

        List<PythagoreanTriplet> build() {
            List<PythagoreanTriplet> tripletsList = new ArrayList<PythagoreanTriplet>();

            for(int i=1;i<=factorsLessThanOrEqualTo/2;i++) {
                for(int j=i+1;j<=(factorsLessThanOrEqualTo - i)/2;j++) {
                    if(i != j) {
                        int k = sumTo - i - j;

                        if(j != k) {
                            if(i*i + j*j == k*k)
                                tripletsList.add(new PythagoreanTriplet(i, j, k));
                        }
                    }
                }
            }

            return tripletsList;
        }
    }

}