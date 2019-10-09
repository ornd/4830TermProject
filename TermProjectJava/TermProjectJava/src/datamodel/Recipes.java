package datamodel;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Recipes")
public class Recipes {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id")
   private Integer id;

   @Column(name = "name")
   private String name;

   @Column(name = "ingredients")
   private String ingredients;

   @Column(name = "instructions")
   private String instructions;
   
   public Recipes() {
   }

   public Recipes(Integer id, String name, String ingredients, String instructions) {
      this.id = id;
      this.name = name;
      this.ingredients = ingredients;
      this.instructions = instructions;
   }

   public Recipes(String name, String ingredients, String instructions) {
      this.name = name;
      this.ingredients = ingredients;
      this.instructions = instructions;
   }

   public Integer getId() {
      return id;
   }

   public void setId(Integer id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getIngredients() {
      return ingredients;
   }

   public void setIngredients(String ingredients) {
      this.ingredients = ingredients;
   }

   public String getInstructions() {
	   return instructions;
   }

   public void setPhone(String instructions) {
	   this.instructions = instructions;
   }
   
   @Override
   public String toString() {
      return "Employee: " + this.id + ", " + this.name + ", " + this.ingredients + ", " + this.instructions;
   }
}