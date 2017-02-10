package org.Clone;

public class Wife implements Cloneable {
    private int id;  
    private String name;  
  
    public int getId() {  
        return id;  
    }  
  
    public void setId(int id) {  
        this.id = id;  
    }  
  
    public String getName() {  
        return name;  
    }  
  
    public void setName(String name) {  
        this.name = name;  
    }  
  
    public Wife(int id,String name) {  
        this.id = id;  
        this.name = name;  
    }  
  
    @Override  
    public int hashCode() {//myeclipse自动生成的  
        final int prime = 31;  
        int result = 1;  
        result = prime * result + id;  
        result = prime * result + ((name == null) ? 0 : name.hashCode());  
        return result;  
    }  
  
    @Override  
    public boolean equals(Object obj) {//myeclipse自动生成的  
        if (this == obj)  
            return true;  
        if (obj == null)  
            return false;  
        if (getClass() != obj.getClass())  
            return false;  
        Wife other = (Wife) obj;  
        if (id != other.id)  
            return false;  
        if (name == null) {  
            if (other.name != null)  
                return false;  
        } else if (!name.equals(other.name))  
            return false;  
        return true;  
    }  
  
    @Override  
    public Object clone() throws CloneNotSupportedException {  
        return super.clone();  
    }  
  
    /** 
     * @param args 
     * @throws CloneNotSupportedException  
     */  
    public static void main(String[] args) throws CloneNotSupportedException {  
        Wife wife = new Wife(1,"wang");  
        Wife wife2 = null;  
        wife2 = (Wife) wife.clone();  
        System.out.println("class same="+(wife.getClass()==wife2.getClass()));//true  
        System.out.println("object same="+(wife==wife2));//false  
        System.out.println("object equals="+(wife.equals(wife2)));//true  
    }  
} 