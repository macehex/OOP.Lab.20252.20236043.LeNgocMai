package hust.soict.itep.aims.media;

import java.util.ArrayList;

public abstract class Media {

        protected int id;
        private String title;
        private String category;
        private double cost;
//        private static int numberOfObjects = 0;
//        private int incrementId(){
//            numberOfObjects++;
//            return id = numberOfObjects;
//        }

        public Media(int id, String title, String category, double cost) {
            this.id = id;
            this.title = title;
            this.category = category;
            this.cost = cost;
        }
        public Media(int id, String title) {
            this.title = title;
            this.id = id;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

    public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public double getCost() {
            return cost;
        }

        public void setCost(double cost) {
            this.cost = cost;
        }
}
