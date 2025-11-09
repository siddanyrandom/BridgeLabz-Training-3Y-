class DividePens {
    public static void main(String[] args) {
        int pens = 14, students = 3;
        int pensPerStudent = pens / students;
        int remaining = pens % students;
        System.out.println("The Pen Per Student is " + pensPerStudent + " and the remaining pen not distributed is " + remaining);
    }
}
