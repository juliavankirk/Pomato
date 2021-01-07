package view.menu.loggedin.project;

import controllers.Controller;
import model.project.Idea;
import view.VMenu;
import view.menu.loggedin.project.ideaboard.*;

import java.util.ArrayList;

public class VMenuIdeaBoard extends VMenu {

    /**
     * Constructor
     */
    public VMenuIdeaBoard(VMenu parent) {
        super(parent);
        mMenuHeader = "Project Ideas";
        mMenuLabel = "View Idea Board";
        mMenuQuestion = "Enter choice";
        mSubMenus = new ArrayList<>();
        mSubMenus.add(new VMenuAddIdea(this));
        mSubMenus.add(new VMenuLikeIdea(this));
        mSubMenus.add(new VMenuDisLikeIdea(this));
        mSubMenus.add(new VMenuViewComment(this));
        mSubMenus.add(new VMenuAddComment(this));
        mSubMenus.add(new VMenuRemoveIdea(this));
    }

    /**
     * Methods
     */

    public void menuContent(Controller controller) {

        int numberOfIdeas = controller.getCurrentProject().getIdeas().size();
        if (numberOfIdeas != 0) {
            ArrayList<Idea> ideaList = controller.getCurrentProject().getIdeas();
            for (int i = 0; i < ideaList.size(); i++) {

                int ideaLength = ideaList.get(i).getIdeaContent().length();
                int ideaNum = String.valueOf( i + 1).length();
                int likeLength = String.valueOf(ideaList.get(i).getLike()).length();
                int disLikeLength = String.valueOf(ideaList.get(i).getDisLike()).length();
                int commentsSizeLength = String.valueOf(ideaList.get(i).getComment().size()).length();

                for (int j = 0; j < ideaLength + 6; j++) {
                    System.out.print("#");
                }
                System.out.println("");

                System.out.print("#  Idea Number: " + (i + 1));
                for(int j = 0; j < (ideaLength - 11 - ideaNum); j++) {
                    System.out.print(" ");
                }
                System.out.println("#");

                System.out.println("#  " + ideaList.get(i) + "  #");

                System.out.print("#  Likes: " + ideaList.get(i).getLike());
                for(int j = 0; j < (ideaLength - 5 - likeLength); j++) {
                    System.out.print(" ");
                }
                System.out.println("#");

                System.out.print("#  Dislikes: " + ideaList.get(i).getDisLike());
                for(int j = 0; j < (ideaLength - 8 - disLikeLength); j++) {
                    System.out.print(" ");
                }
                System.out.println("#");

                System.out.print("#  Number of comments: " + ideaList.get(i).getComment().size());
                for(int j = 0; j < (ideaLength - 18 - commentsSizeLength); j++) {
                    System.out.print(" ");
                }
                System.out.println("#");

                for (int j = 0; j < ideaLength + 6; j++) {
                    System.out.print("#");
                }
                System.out.println("");
            }
            System.out.println("");
        } else {
            String prompt= "There is no idea available for this project yet. Come on people. Be more creative!";
            for (int i = 0; i < prompt.length() + 6 ; i++) {
                System.out.print("#");
            }
        System.out.println("");
        System.out.println("#  " + prompt + "  #");
        for (int i = 0; i < prompt.length() + 6 ; i++) {
            System.out.print("#");
        }
        System.out.println("");
        }

    }
}
