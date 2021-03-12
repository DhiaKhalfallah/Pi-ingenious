<?php

namespace App\Entity;

use App\Repository\InterviewRepository;
use Doctrine\ORM\Mapping as ORM;
use Symfony\Component\Validator\Constraints as Assert;


/**
 * @ORM\Entity(repositoryClass=InterviewRepository::class)
 */
class Interview
{
    /**
     * @ORM\Id
     * @ORM\GeneratedValue
     * @ORM\Column(type="integer")
     */
    private $id;

    /**
     * @ORM\Column(type="date")
     * @Assert\Date
     * @Assert\GreaterThan("today" , message=" date '{{ value }}' vnon valide")
     */
    
    private $date_temps;

    /**
     * @ORM\Column(type="string", length=255, nullable=true)
     */
    private $commentaire;

   
    /**
     * @ORM\ManyToOne(targetEntity=Entreprise::class, inversedBy="interviews")
     */
    private $enteprise;

    /**
     * @ORM\ManyToOne(targetEntity=Candidature::class, inversedBy="interviews")
     */
    private $cand;

    public function getId(): ?int
    {
        return $this->id;
    }

    public function getDateTemps(): ?\DateTimeInterface
    {
        return $this->date_temps;
    }

    public function setDateTemps(\DateTimeInterface $date_temps): self
    {
        $this->date_temps = $date_temps;

        return $this;
    }

    public function getCommentaire(): ?string
    {
        return $this->commentaire;
    }

    public function setCommentaire(?string $commentaire): self
    {
        $this->commentaire = $commentaire;

        return $this;
    }

 
 

    public function getEnteprise(): ?Entreprise
    {
        return $this->enteprise;
    }

    public function setEnteprise(?Entreprise $enteprise): self
    {
        $this->enteprise = $enteprise;

        return $this;
    }

    public function getCand(): ?Candidature
    {
        return $this->cand;
    }

    public function setCand(?Candidature $cand): self
    {
        $this->cand = $cand;

        return $this;
    }
}
