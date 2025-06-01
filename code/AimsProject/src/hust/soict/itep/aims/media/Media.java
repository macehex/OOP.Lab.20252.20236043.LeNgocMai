package hust.soict.itep.aims.media;

import hust.soict.itep.aims.exception.AimsException;

public abstract class Media implements Comparable<Media> {
    public static final java.util.Comparator<Media> COMPARATOR_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final java.util.Comparator<Media> COMPARATOR_BY_COST_TITLE = new MediaComparatorByCostTitle();

    private int id;
    private String title;
    private String category;
    private float cost;

    public Media(int id, String title, String category, float cost) throws AimsException {
        if (title == null || title.trim().isEmpty()) {
            throw new AimsException("Title cannot be null or empty");
        }
        if (cost < 0) {
            throw new AimsException("Cost cannot be negative");
        }
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    public Media() {
    }

    @Override
    public boolean equals(Object obj) {
        try {
            if (obj == null) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Media)) {
                return false;
            }
            Media other = (Media) obj;
            return this.getTitle().equals(other.getTitle())
                    && Float.compare(this.getCost(), other.getCost()) == 0;
        } catch (NullPointerException e) {
            return false;
        } catch (ClassCastException e) {
            return false;
        }
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((title == null) ? 0 : title.hashCode());
        result = prime * result + Float.floatToIntBits(cost);
        return result;
    }

    @Override
    public int compareTo(Media other) {
        try {
            int titleComparison = this.getTitle().compareTo(other.getTitle());
            if (titleComparison != 0) {
                return titleComparison;
            }
            return Float.compare(this.getCost(), other.getCost());
        } catch (NullPointerException e) {
            throw new RuntimeException("Cannot compare with null media", e);
        }
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public float getCost() {
        return cost;
    }

    protected void setTitle(String title) {
        this.title = title;
    }

    protected void setCategory(String category) {
        this.category = category;
    }

    protected void setCost(float cost) {
        this.cost = cost;
    }

    protected void setId(int id) {
        this.id = id;
    }
}