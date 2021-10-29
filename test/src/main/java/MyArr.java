public class MyArr {
    private Person[] arr;
    private int size;

    public MyArr(int size){
        this.size = 0;
        this.arr = new Person[size];
    }

    public boolean find(String search){
        int i;
        System.out.println("size = " + size);
        System.out.println("this.size = " + this.size);
        for(i=0;i<this.size;i++){
            if (this.arr[i].getName().equals(search)) break;
        }
        if (i==this.size)
            return false;
        else
            return true;
    }

    public void display(){
        System.out.println("size = " + size);
        System.out.println("this.size = " + this.size);
        for(int i=0;i<this.size;i++){
            System.out.println(this.arr[i].getName()+" "+this.arr[i].getAge());
        }
    }

    public void delete(String search){
        int i=0;
        System.out.println("size = " + size);
        System.out.println("this.size = " + this.size);
        System.out.println("arr = " + arr);
        System.out.println("this.arr = " + this.arr);
        for(i=0;i<this.size;i++){
            if (this.arr[i].getName().equals(search)) break;
        }
        System.out.println("arr = " + arr);
        System.out.println("this.arr = " + this.arr);
        for (int j=i;j<this.size-1; j++){
            this.arr[j] = this.arr[j+1];
        }
        this.size--;
        System.out.println("size = " + size);
        System.out.println("this.size = " + this.size);
    }

    public void insert(String name, int age){
        System.out.println("size = " + size);
        System.out.println("this.size = " + this.size);
        this.arr[this.size] = new Person(name, age);
        this.size++;
        System.out.println("size = " + size);
        System.out.println("this.size = " + this.size);
    }

}
