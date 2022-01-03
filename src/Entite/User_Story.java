/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;

/**
 *
 * @author Lenovo
 */
public class User_Story {
    public int id_user_story;
    public String user_story_description;
    public int doing;
    public int total_estimation_userStory_jours;
    public int priority;
    public int id_feature; 
    public int id_PB;

  

   
    public User_Story(int id_user_story, String user_story_description, int doing, int total_estimation_userStory_jours, int priority, int id_feature ,int id_PB) {
        this.id_user_story = id_user_story;
        this.user_story_description = user_story_description;
        this.doing = doing;
        this.total_estimation_userStory_jours = total_estimation_userStory_jours;
        this.priority = priority;
        this.id_feature = id_feature;
        this.id_PB = id_PB;
    }
    
    
      public int getId_PB() {
        return id_PB;
    }

    public void setId_PB(int id_PB) {
        this.id_PB = id_PB;
    }
    

    public int getId_user_story() {
        return id_user_story;
    }

    public String getUser_story_description() {
        return user_story_description;
    }

    public int getDoing() {
        return doing;
    }

    public int getTotal_estimation_userStory_jours() {
        return total_estimation_userStory_jours;
    }

    public int getPriority() {
        return priority;
    }

    public int getId_feature() {
        return id_feature;
    }

    public void setId_user_story(int id_user_story) {
        this.id_user_story = id_user_story;
    }

    public void setUser_story_description(String user_story_description) {
        this.user_story_description = user_story_description;
    }

    public void setDoing(int doing) {
        this.doing = doing;
    }

    public void setTotal_estimation_userStory_jours(int total_estimation_userStory_jours) {
        this.total_estimation_userStory_jours = total_estimation_userStory_jours;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public void setId_feature(int id_feature) {
        this.id_feature = id_feature;
    }

    @Override
    public String toString() {
        return "User_Story{" + "id_user_story=" + id_user_story + ", user_story_description=" + user_story_description + ", doing=" + doing + ", total_estimation_userStory_jours=" + total_estimation_userStory_jours + ", priority=" + priority + ", id_feature=" + id_feature + '}';
    }
    
}
