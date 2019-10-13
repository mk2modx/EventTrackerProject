import { Jobapp } from './jobapp';
import { Tech } from './tech';

export class User {
  id: number;
  firstName: string;
  lastName: string;
  email: string;
  cohort: string;
  applications: Jobapp[];
  technologies: Tech[];

  constructor(
    id?: number,
    firstName?: string,
    lastName?: string,
    email?: string,
    cohort?: string,
    applications?: Jobapp[],
    technologies?: Tech[] // can remove ? and provide default (completed: false)
  ) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.cohort = cohort;
    this.applications = applications;
    this.technologies = technologies;
  }

}
