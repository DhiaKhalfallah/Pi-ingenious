<?php

namespace App\Controller;

use App\Entity\User;
use App\Entity\Offre;
use App\Form\OffreType;
use App\Repository\UserRepository;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;

class TemplateController extends AbstractController
{
    /**
     * @Route("/admin", name="template")
     */
    public function index(): Response
    {
        return $this->render('admin/dashboard-1.html.twig', [
            'controller_name' => 'TemplateController',
        ]);
    }
    /**
     * @Route("/user-profile", name="user_profile")
     */
    public function user_profile(): Response
    {
        return $this->render('user_profile.html.twig', [
            'controller_name' => 'TemplateController',
        ]);
    }
    /**
     * @Route("/user-profile-edit", name="user-profile-edit")
     */
    public function user_profile_edit(): Response
    {
        return $this->render('user-profile-edit.html.twig', [
            'controller_name' => 'TemplateController',
        ]);
    }
    /**
     * @Route("/user-privacy", name="user-privacy")
     */
    public function user_privacy(): Response
    {
        return $this->render('user-privacy-setting.html.twig', [
            'controller_name' => 'TemplateController',
        ]);
    }

    /**
     * @return Response
     * @Route("/user-list",name="user-list")
     */
    public function user_list(): Response
    {
        return $this->render('user-list.html.twig', [
            'controller_name' => 'TemplateController',
        ]);
    }
    /**
     * @return Response
     * @Route("/admin/user-add",name="user-add")
     */
    public function user_add(): Response
    {
        return $this->render('admin/user-add.html.twig', [
            'controller_name' => 'TemplateController',
        ]);
    }
    /**
     * @return Response
     * @Route("/user-account",name="user-account")
     */
    public function user_acc(): Response
    {
        return $this->render('user-account-setting.html.twig', [
            'controller_name' => 'TemplateController',
        ]);
    }
    /**
     * @return Response
     * @Route("/todo",name="todo")
     */
    public function todo(): Response
    {
        return $this->render('todo.html.twig', [
            'controller_name' => 'TemplateController',
        ]);
    }

    /**
     * @return Response
     * @Route("/email_compose",name="email_compose")
     */
    public function email_compose(): Response
    {
        return $this->render('email-compose.html.twig', [
            'controller_name' => 'TemplateController',
        ]);
    }

    /**
     * @return Response
     * @Route("/email",name="email")
     */
    public function email(): Response
    {
        return $this->render('email.html.twig', [
            'controller_name' => 'TemplateController',
        ]);
    }

    /**
     * @return Response
     * @Route("/chat",name="chat")
     */
    public function chat(): Response
    {
        return $this->render('chat.html.twig', [
            'controller_name' => 'TemplateController',
        ]);
    }





    /**
     * @return Response
     * @Route("/auth-confirm-mail
    ",name="auth-confirm-mail
    ")
     */
    public function auth_confirm_mail (): Response
    {
        return $this->render('auth-confirm-mail.html.twig', [
            'controller_name' => 'TemplateController',
        ]);
    }

    /**
     * @return Response
     * @Route("/auth-lock-screen
    ",name="auth-lock-screen
    ")
     */
    public function auth_lock_screen (): Response
    {
        return $this->render('auth-lock-screen.html.twig', [
            'controller_name' => 'TemplateController',
        ]);
    }



    /**
     * @return Response
     * @Route("/auth-recoverpw
    ",name="auth-recoverpw
    ")
     */
    public function auth_recoverpw (): Response
    {
        return $this->render('auth-recoverpw.html.twig', [
            'controller_name' => 'TemplateController',
        ]);
    }
    /**
     * @return Response
     * @Route("/auth-sign-in",name="auth-sign-in")
     */
    public function auth_sign_in (): Response
    {
        return $this->render('auth-sign-in .html.twig', [
            'controller_name' => 'TemplateController',
        ]);
    }

    /**
     * @return Response
     * @Route("/auth-sign-up
    ",name="auth-sign-up
    ")
     */
    public function auth_sign_up(): Response
    {
        return $this->render('auth-sign-up.html.twig', [
            'controller_name' => 'TemplateController',
        ]);
    }

    /**
     * @return Response
     * @Route("/chart
    ",name="chart
    ")
     */
    public function chart(): Response
    {
        return $this->render('chart.html.twig', [
            'controller_name' => 'TemplateController',
        ]);
    }

    /**
     * @return Response
     * @Route("/chart_high
    ",name="chart_high
    ")
     */
    public function chart_high(): Response
    {
        return $this->render('chart_high.html.twig', [
            'controller_name' => 'TemplateController',
        ]);
    }

    /**
     * @return Response
     * @Route("/chart_morris
    ",name="chart_morris
    ")
     */
    public function chart_morris(): Response
    {
        return $this->render('chart_morris.html.twig', [
            'controller_name' => 'TemplateController',
        ]);
    }



  /**
     * @return Response
     * @Route("admin/tables_basic",name="offre")
     */
    public function table_basic(): Response
    {
        return $this->render('admin/tables-basic.html.twig', [
            'controller_name' => 'TemplateController',
        ]);
    }
    /**
     * @return Response
     * @Route("/admin/tables_data",name="tables_data")
     */
    public function data_table(): Response
    {
        return $this->render('admin/table-data.html.twig', [
            'controller_name' => 'TemplateController',
        ]);
    }


    /**
     * @return Response
     * @Route("/tables_tree
    ",name="tables_tree
    ")
     */
    public function tree_table(): Response
    {
        return $this->render('table_tree.html.twig', [
            'controller_name' => 'TemplateController',
        ]);
    }



    /**
     * @return Response
     * @Route("/table_edit
    ",name="table_edit
    ")
     */
    public function edit_table(): Response
    {
        return $this->render('table_edit.html.twig', [
            'controller_name' => 'TemplateController',
        ]);
    }
    /**
     * @return Response
     * @Route("/error
    ",name="error
    ")
     */
    public function error(): Response
    {
        return $this->render('error.html.twig', [
            'controller_name' => 'TemplateController',
        ]);
    }

    /**
     * @return Response
     * @Route("/error500
    ",name="error500
    ")
     */
    public function error500(): Response
    {
        return $this->render('error500.html.twig', [
            'controller_name' => 'TemplateController',
        ]);
    }


    /**
     * @return Response
     * @Route("/pricing
    ",name="pricing
    ")
     */
    public function pricing(): Response
    {
        return $this->render('pricing.html.twig', [
            'controller_name' => 'TemplateController',
        ]);
    }
    /**
     * @return Response
     * @Route("/inovice
    ",name="inovice
    ")
     */
    public function inovice(): Response
    {
        return $this->render('inovice.html.twig', [
            'controller_name' => 'TemplateController',
        ]);
    }



    /**
     * @return Response
     * @Route("/faq
    ",name="faq
    ")
     */
    public function faq(): Response
    {
        return $this->render('faq.html.twig', [
            'controller_name' => 'TemplateController',
        ]);
    }


    /**
     * @return Response
     * @Route("/main
    ",name="main
    ")
     */
    public function main(): Response
    {
        return $this->render('maintament.html.twig', [
            'controller_name' => 'TemplateController',
        ]);
    }



    /**
     * @return Response
     * @Route("/cms
    ",name="cms
    ")
     */
    public function cms(): Response
    {
        return $this->render('cms.html.twig', [
            'controller_name' => 'TemplateController',
        ]);
    }

    /**
     * @return Response
     * @Route("/blank
    ",name="blank
    ")
     */
    public function blank(): Response
    {
        return $this->render('blankpage.html.twig', [
            'controller_name' => 'TemplateController',
        ]);
    }

    /**
     * @Route("/create-job", name="create-job")
     */
    public function create_job(Request $request ): Response
    {
        $offre = new Offre();
        $form = $this->createForm(OffreType::class, $offre);
        $form->handleRequest($request);
        $var = "hello" ; 

        if ($form->isSubmitted() && $form->isValid()) {
            $entityManager = $this->getDoctrine()->getManager();
            $uploadedFile = $form['logo']->getData();
            $filename = md5(uniqid()).'.'.$uploadedFile->guessExtension();
            $uploadedFile->move($this->getParameter('uploads_directory'),$filename);
            $offre->setLogo($filename);
            $offre->setEnteprise($this->getUser()); 
            $entityManager = $this->getDoctrine()->getManager();
            $entityManager->persist($offre);
            $entityManager->flush();

            return $this->redirectToRoute('job');
        }

        return $this->render('for_employer/create-job.html.twig', [
            'offre' => $offre,
            'form' => $form->createView(),
            'var'=>$var
        ]);
    }






}
