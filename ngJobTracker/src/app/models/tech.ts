import { Jobapp } from './jobapp';
import { User } from './user';

export class Tech {
  id: number;
  name: string;
  link: string;
  applications: Jobapp[];
  users: User[];

  constructor(
    id?: number,
    name?: string,
    link?: string,
    applications?: Jobapp[],
    users?: User[]
   // can remove ? and provide default (completed: false)
  ) {
    this.id = id;
    this.name = name;
    this.link = link;
    this.applications = applications;
    this.users = users;
  }

}
