 public boolean checkuser(){
   try {
      System.out.println("user name "+user_name);
      System.out.println("passowrd "+password);
      SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
      Session session=sessionFactory.openSession();
      session.beginTransaction();
      Query query=session.createQuery("from Login where user_name=:user_name and password=:password");
      query.setString("user_name", user_name);
      query.setString("password", password);
      List list=query.list();
      System.out.println("list size "+list.size());
      if(list.size()==1){
            return true;
      }else{
            return false;
      }
    } catch (Exception e) {
        System.out.println(e);
    }
    return false;
   }
