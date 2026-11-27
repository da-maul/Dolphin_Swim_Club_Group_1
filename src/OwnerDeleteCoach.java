public class OwnerDeleteCoach implements Actable{

    //deletes coaches, does what it says on the tin.
    @Override
    public void act(Club club) {
        String coachName = IO.readln("Enter Coach to delete:");
        Coach coachToDelete = new Coach(coachName);
        if (club.getCoaches().contains(coachToDelete)){
            club.deleteCoach(coachToDelete);
        }
    }
}
//Wario