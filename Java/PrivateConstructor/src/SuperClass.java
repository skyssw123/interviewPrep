
public class SuperClass {
	int age;
	String name;
	public SuperClass(int age, String name) //If we change public to private for constructor, it generates error since
	{										//our subclass wants to call super() which is set as private
		this.age = age;
		this.name = name;
	}
	public static class Builder
	{
		private int age;
		private String name;
		public Builder withName(final String name)
		{
			this.name = name;
			return this;
		}
		public Builder withAge(final int age)
		{
			this.age = age;
			return this;
		}
		public SuperClass build()
		{
			if(name == null || age == 0)
				throw new IllegalStateException("Cannot Create");
			return new SuperClass(age, name);
		}
	}
}
