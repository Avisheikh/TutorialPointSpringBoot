export class GetTempUserList
{

  userId:number;
  userName:string;
  email:string;
  phoneNumber:number;
  pan:number;
  password:string;

  // constructor(
  //   public userId:number,
  //   public userName:string,
  //   public email:string,
  //   public phoneNumber:number,
  //   public pan:number,
  //   public password:string
  // ) {}


  constructor(userId: number, userName: string, email: string, phoneNumber: number, pan: number, password: string) {
    this.userId = userId;
    this.userName = userName;
    this.email = email;
    this.phoneNumber = phoneNumber;
    this.pan = pan;
    this.password = password;
  }

}
