package day19HashAndMap;

public class TestHash {
	static class Student {
		// FIELDs
		private String name;
		private int score;
		// Constructor
		public Student(String name, int score) {
			super();
			this.name = name;
			this.score = score;
		}
		// Getter and Setter
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getScore() {
			return score;
		}
		public void setScore(int score) {
			this.score = score;
		}
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
//			result = prime * result + score;
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			
			Student other = (Student) obj;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			if (score != other.score)
				return false;
			
			return true;
		}
		
		
	}
	public static void main(String[] args) {
		Student s = new Student("m", 100);
		System.out.println(s.hashCode());
	}
}
