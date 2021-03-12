<?php

namespace App\Controller;

use App\Entity\User;
use App\Entity\Admin;
use App\Form\AdminType;
use App\Form\EditCType;
use App\Form\EditEType;
use App\Entity\Candidate;
use App\Entity\Entreprise;
use App\Form\RegisterType;
use App\Entity\Reclamation;
use App\Form\RegisterCType;
use App\Form\RegisterEType;
use App\Form\ReclamationType;
use App\Repository\UserRepository;
use App\Repository\CandidateRepository;
use App\Repository\EntrepriseRepository;

use phpDocumentor\Reflection\Types\This;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;
use Symfony\Component\Security\Core\User\UserInterface;
use Symfony\Component\Security\Core\Encoder\UserPasswordEncoder;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\Security\Http\Authentication\AuthenticationUtils;
use Symfony\Component\Security\Core\Encoder\UserPasswordEncoderInterface;


class RoutesController extends AbstractController
{
    /**
     * @Route("/", name="acceuil")
     */
    public function index(): Response
    {
        return $this->render('index.html.twig', [
            'controller_name' => 'RoutesController',
        ]);
    }

    /**
     * @Route("/accordion", name="accordion")
     */
    public function accordion(): Response
    {
        return $this->render('main_pages/accordion.html.twig', [
            'controller_name' => 'RoutesController',
        ]);
    }
    /**
     * @Route("/browsecompany", name="browsecompany")
     */
    public function browsecompany(): Response
    {
        return $this->render('for_candidates/browse-company.html.twig', [
            'controller_name' => 'RoutesController',
        ]);
    }
    /**
     * @Route("/browse-jobs", name="browse-jobs")
     */
    public function browse_jobs(): Response
    {
        return $this->render('for_candidates/browse-jobs.html.twig', [
            'controller_name' => 'RoutesController',
        ]);
    }
    /**
     * @Route("/browse-resume", name="browse-resume")
     */
    public function browse_resume(): Response
    {
        return $this->render('for_employer/browse-resume.html.twig', [
            'controller_name' => 'RoutesController',
        ]);
    }
    /**
     * @Route("/candidate-profile", name="candidate-profile")
     */
    public function candidate_profile(): Response
    {

        /*$user=$this->getDoctrine()->getRepository(Candidate::
        class)->findOneBy(array(id));
        console.log($user);*/
        return $this->render('for_candidates/candidate-profile.html.twig', [
            'controller_name' => 'RoutesController',
        ]);
    }
    /**
     * @Route("/contact/{mail}/{id}", name="contact")
     */
    public function contact(Request $request, $mail, $id): Response
    {
        $user= new Reclamation() ;
        $form = $this->createForm(ReclamationType::class, $user);
        $form->handleRequest($request);
        if ($form->isSubmitted() && $form->isValid())
        {
            $user->setUserEmail($mail);
            $user->setUserId($id);
            $entitymanager = $this->getDoctrine()->getManager();
            $entitymanager->persist($user);
            $entitymanager->flush();
            return $this->redirectToRoute('routes');
        }

        return $this->render('contact.html.twig',
            array('form'=> $form->createView())
        );
    }
    /**
     * @Route("/create-resume", name="create-resume")
     */
    public function create_resume(): Response
    {
        return $this->render('for_candidates/create-resume.html.twig', [
            'controller_name' => 'RoutesController',
        ]);
    }
    /**
     * @Route("/employer-profile", name="employer-profile")
     */
    public function employer_profile(): Response
    {
        return $this->render('for_employer/employer-profile.html.twig', [
            'controller_name' => 'RoutesController',
        ]);
    }
    /**
     * @Route("/faq", name="faq")
     */
    public function faq(): Response
    {
        return $this->render('faq.html.twig', [
            'controller_name' => 'RoutesController',
        ]);
    }
    /**
     * @Route("/freelancer-detail", name="freelancer-detail")
     */
    public function freelancer_detail(): Response
    {
        return $this->render('freelance_space/freelancer-detail.html.twig', [
            'controller_name' => 'RoutesController',
        ]);
    }

 
    /**
     * @Route("/freelancers", name="freelancers")
     */
    public function freelancers(): Response
    {
        return $this->render('freelance_space/freelancers.html.twig', [
            'controller_name' => 'RoutesController',
        ]);
    }
    /**
     * @Route("/freelancing", name="freelancing")
     */
    public function freelancing(): Response
    {
        return $this->render('main_pages/freelancing.html.twig', [
            'controller_name' => 'RoutesController',
        ]);
    }
    /**
     * @Route("/freelancing-jobs", name="freelancing-jobs")
     */
    public function freelancing_jobs(): Response
    {
        return $this->render('freelance_space/freelancing-jobs.html.twig', [
            'controller_name' => 'RoutesController',
        ]);
    }
    /**
     * @Route("/job-apply-detail", name="job-apply-detail")
     */
    public function job_apply_detail(): Response
    {
        return $this->render('for_employer/job-apply-detail.html.twig', [
            'controller_name' => 'RoutesController',
        ]);
    }
    /**
     * @Route("/job-detail", name="job-detail")
     */
    public function job_detail(): Response
    {
        return $this->render('for_employer/job-detail.html.twig', [
            'controller_name' => 'RoutesController',
        ]);
    }
    /**
     * @Route("/login", name="login")
     */
    public function login(): Response
    {
        return $this->render('login_singup/login.html.twig', [
            'controller_name' => 'RoutesController',
        ]);
    }
    /**
     * @Route("/lost-password", name="lost-password")
     */
    public function lost_password(): Response
    {
        return $this->render('login_singup/lost-password.html.twig', [
            'controller_name' => 'RoutesController',
        ]);
    }
    /**
     * @Route("/manage-candidate", name="manage-candidate")
     */
    public function manage_candidate(): Response
    {
        return $this->render('for_employer/manage-candidate.html.twig', [
            'controller_name' => 'RoutesController',
        ]);
    }
    /**
     * @Route("/new-login-signup", name="new-login-signup")
     */
    public function new_login_signup(): Response
    {
        return $this->render('login_singup/new-login-signup.html.twig', [
            'controller_name' => 'RoutesController',
        ]);
    }
    /**
     * @Route("pricing", name="pricing")
     */
    public function pricing(): Response
    {
        return $this->render('pricing.html.twig', [
            'controller_name' => 'RoutesController',
        ]);
    }
    /**
     * @Route("/resume-detail", name="resume-detail")
     */
    public function resume_detail(): Response
    {
        return $this->render('for_candidates/resume-detail.html.twig', [
            'controller_name' => 'RoutesController',
        ]);
    }
    /**
     * @Route("/search-job", name="search-job")
     */
    public function search_job(): Response
    {
        return $this->render('search-job.html.twig', [
            'controller_name' => 'RoutesController',
        ]);
    }
    /**
     * @Route("/search-new", name="search-new")
     */
    public function search_new(): Response
    {
        return $this->render('for_candidates/search-new.html.twig', [
            'controller_name' => 'RoutesController',
        ]);
    }
    /**
     * @Route("/signin-signup", name="signin-signup")
     */
    public function signin_signup()
    {

        return $this->render('main_pages/signin-signup.html.twig'
        );
    }
    /**
     * @Route("/signup", name="signup")
     */
    public function signup(): Response
    {
        return $this->render('login_singup/new-login-signup.html.twig', [
            'controller_name' => 'RoutesController',
        ]);
    }
    /**
     * @Route("/blog", name="blog")
     */
    public function blog(): Response
    {
        return $this->render('blog.html.twig', [
            'controller_name' => 'RoutesController',
        ]);
    }
    /**
     * @Route("/blog-detail", name="blog-detail")
     */
    public function blog_detail(): Response
    {
        return $this->render('blog-detail.html.twig', [
            'controller_name' => 'RoutesController',
        ]);
    }
    /**
     * @Route("/create-job", name="create-job")
     */
    public function create_job(): Response
    {
        return $this->render('for_employer/create-job.html.twig', [
            'controller_name' => 'RoutesController',
        ]);
    }
    /**
     * @Route("/chat", name="chat")
     */
    public function chat(): Response
    {
        return $this->render('chat.html.twig', [
            'controller_name' => 'RoutesController',
        ]);
    }
    /**
     * @Route("/company-detail", name="chat")
     */
    public function company_detail(): Response
    {
        return $this->render('for_candidates/company-detail.html.twig', [
            'controller_name' => 'RoutesController',
        ]);
    }

    /**
     * @Route("/signup-admin", name="signup-admin")
     */
    public function signup_admin(Request $request , UserPasswordEncoderInterface $passwordEncoder ): Response
    {

        $user= new Admin() ;
        $form = $this->createForm(AdminType::class, $user);
        $form->handleRequest($request);
        if ($form->isSubmitted() && $form->isValid())
        {
            $user->setRoles(array('ROLE_ADMIN'));
            $passwordH = $passwordEncoder->encodePassword($user,$user->getPassword());
            $user->setPassword($passwordH);
            $entitymanager = $this->getDoctrine()->getManager();
            $entitymanager->persist($user);
            $entitymanager->flush();
            return $this->redirectToRoute('login');
        }



        return $this->render('login_singup/signup-admin.html.twig',
            array('form'=> $form->createView())

        );
    }


    /**
     * @Route("/signup-candidate", name="signup-candidate")
     */
    public function signup_candidate(Request $request , UserPasswordEncoderInterface $passwordEncoder ,AuthenticationUtils $utils): Response
    {

        $user= new Candidate() ;
        $form = $this->createForm(RegisterCType::class, $user);
        $form->handleRequest($request);
        if ($form->isSubmitted() && $form->isValid())
        {


                $file = $request->files->get('register_c')['profilePic'];
                $uploads_directory = $this->getParameter('uploads_directory');
                $filename = md5(uniqid()) . '.' . $file->guessExtension();
                $file->move(
                    $uploads_directory,
                    $filename
                );
                $user->setProfilePic('uploads/'.$filename);

            $user->setRoles(array('ROLE_CANDIDATE'));

            $passwordH = $passwordEncoder->encodePassword($user,$user->getPassword());
            $user->setPassword($passwordH);
            $entitymanager = $this->getDoctrine()->getManager();
            $entitymanager->persist($user);
            $entitymanager->flush();
            return $this->redirectToRoute('login');
        }



        return $this->render('login_singup/signup-candidate.html.twig',
            array('form'=> $form->createView())

        );
    }
    /**
     * @Route("/signup-entreprise", name="signup-entreprise")
     */
    public function signup_entreprise(Request $request , UserPasswordEncoderInterface $passwordEncoder ): Response
    {

        $user= new Entreprise() ;
        $form = $this->createForm(RegisterEType::class, $user);
        $form->handleRequest($request);
        if ($form->isSubmitted() && $form->isValid())
        {
                $user->setRoles(array('ROLE_ENTEPRISE'));

                $file = $request->files->get('register_e')['profilPic'];
                $uploads_directory = $this->getParameter('uploads_directory');
                $filename = md5(uniqid()) . '.' . $file->guessExtension();
                $file->move(
                    $uploads_directory,
                    $filename
                );
                $user->setProfilPic('uploads/'.$filename);

            $passwordH = $passwordEncoder->encodePassword($user,$user->getPassword());
            $user->setPassword($passwordH);

            $entitymanager = $this->getDoctrine()->getManager();
            $entitymanager->persist($user);
            $entitymanager->flush();
            return $this->redirectToRoute('login');
        }



        return $this->render('login_singup/signup-entreprise.html.twig' ,
            array('form'=> $form->createView())

        );
    }

    /**
     * @Route("/edit-profil/{id}/{i}", name="editC")
     */
    public function edit_profil(CandidateRepository $repository , Request $request , $i ,UserPasswordEncoderInterface $passwordEncoder): Response
    {

        $user=$repository->find($i);
        $form = $this->createForm(EditCType::class,$user);
        $form->handleRequest($request);
        $pic=$user->getProfilePic();

        if ($form->isSubmitted() && $form->isValid()) {

            $file = $request->files->get('edit_c')['profilePic'];
                $uploads_directory = $this->getParameter('uploads_directory');
                $filename = md5(uniqid()) . '.' . $file->guessExtension();
                $file->move(
                    $uploads_directory,
                    $filename
                );
            $user->setProfilePic('uploads/' . $filename);
            $passwordH = $passwordEncoder->encodePassword($user,$user->getPassword());
            $user->setPassword($passwordH);
            $entitymanager = $this->getDoctrine()->getManager();
            $entitymanager->flush();
            return $this->redirectToRoute('candidate-profile');
        }

        return $this->render('for_candidates/edit-profil.html.twig',
            array('form'=> $form->createView())
        );
    }
    /**
     * @Route("/DeleteC/{i}", name="DeleteC")
     */
    public function DeleteC(CandidateRepository $repository , Request $request , $i ): Response
    {

        $user=$repository->find($i);

        $entitymanager = $this->getDoctrine()->getManager();
        $entitymanager->remove($user);
        $entitymanager->flush();
        return $this->redirectToRoute('routes');


    }
    /**
     * @Route("/edit-profilE/{id}/{i}", name="editE")
     */
    public function edit_profilE(EntrepriseRepository $repository , Request $request , $i ,UserPasswordEncoderInterface $passwordEncoder): Response
    {

        $user=$repository->find($i);
        $form = $this->createForm(EditEType::class,$user);
        $form->handleRequest($request);
        if ($form->isSubmitted() && $form->isValid()) {
            /*  echo "<pre>";
              var_dump($request); die ;*/

          $file = $request->files->get('edit_e')['profilPic'];
                $uploads_directory = $this->getParameter('uploads_directory');
                $filename = md5(uniqid()) . '.' . $file->guessExtension();
                $file->move(
                    $uploads_directory,
                    $filename
                );
                $user->setProfilPic('uploads/' . $filename);

            $passwordH = $passwordEncoder->encodePassword($user,$user->getPassword());
            $user->setPassword($passwordH);
            $entitymanager = $this->getDoctrine()->getManager();
            $entitymanager->flush();
            return $this->redirectToRoute('employer-profile');
        }

        return $this->render('for_employer/edit-profilE.html.twig',
            array('form'=> $form->createView())
        );
    }
    /**
     * @Route("/DeleteE/{i}", name="DeleteE")
     */
    public function DeleteE(EntrepriseRepository $repository , Request $request , $i ): Response
    {

        $user=$repository->find($i);

        $entitymanager = $this->getDoctrine()->getManager();
        $entitymanager->remove($user);
        $entitymanager->flush();
        return $this->redirectToRoute('routes');


    }

    /**
     * @Route("/cv", name="cv")
     */
    public function cv()
    {

        return $this->render('for_candidates/cv-temp.html.twig');


    }

}
