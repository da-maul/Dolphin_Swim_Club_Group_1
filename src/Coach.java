public record Coach(String name) {
    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Coach otherCoach){
            return name.equalsIgnoreCase(otherCoach.name());
        }
        else return false;
    }
}
//wario &
