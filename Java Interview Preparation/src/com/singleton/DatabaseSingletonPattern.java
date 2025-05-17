package com.singleton;

class Database {
	private static Database dbObject;

	private Database() {
	}

	public static Database getInstance() {

		// create object if it's not already created
		if (dbObject == null) {
			synchronized (Database.class) {
				if (dbObject == null) {
					dbObject = new Database();
				}
			}
		}
		// returns the singleton object
		return dbObject;
	}

	public void getConnection() {
		System.out.println("You are now connected to the database.");
	}
}

class DatabaseSingletonPattern {
	public static void main(String[] args) {
		Database db1, db2;

		// refers to the only object of Database
		db1 = Database.getInstance();
		db2 = Database.getInstance();
		System.out.println(db1);
		System.out.println(db2);
		db2.getConnection();

	}
}
